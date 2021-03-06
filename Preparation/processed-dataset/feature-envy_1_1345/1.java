/**
     *  Do "smart" encodging on a string. This means that valid HTML entities and tags,
     *  Helma macros and HTML comments are passed through unescaped, while
     *  other occurrences of '<', '>' and '&' are encoded to HTML entities.
     *
     *  @param str the string to encode
     *  @param ret the string buffer to encode to
     *  @param paragraphs if true use p tags for paragraphs, otherwise just use br's
     *  @param allowedTags a set containing the names of allowed tags as strings. All other
     *                     tags will be escaped
     */
public static final void encode(String str, StringBuffer ret, boolean paragraphs, Set allowedTags) {
    if (str == null) {
        return;
    }
    int l = str.length();
    // where to insert the <p> tag in case we want to create a paragraph later on  
    int paragraphStart = ret.length();
    // what kind of element/text are we leaving and entering?  
    // this is one of TEXT|SEMIBLOCK|BLOCK|INTERNAL  
    // depending on this information, we decide whether and how to insert  
    // paragraphs and line breaks. "entering" a tag means we're at the '<'  
    // and exiting means we're at the '>', not that it's a start or close tag.  
    byte entering = TEXT;
    byte exiting = TEXT;
    Stack openTags = new Stack();
    // are we currently within a < and a > that consitute some kind of tag?  
    // we use tag balancing to know whether we are inside a tag (and should  
    // pass things through unchanged) or outside (and should encode stuff).  
    boolean insideTag = false;
    // are we inside an HTML tag?  
    boolean insideHtmlTag = false;
    boolean insideCloseTag = false;
    byte htmlTagMode = TAG_NAME;
    // if we are inside a <code> tag, we encode everything to make  
    // documentation work easier  
    boolean insideCodeTag = false;
    boolean insidePreTag = false;
    // are we within a Helma <% macro %> tag? We treat macro tags and  
    // comments specially, since we can't rely on tag balancing  
    // to know when we leave a macro tag or comment.  
    boolean insideMacroTag = false;
    // are we inside an HTML comment?  
    boolean insideComment = false;
    // the quotation mark we are in within an HTML or Macro tag, if any  
    char htmlQuoteChar = ' ';
    char macroQuoteChar = ' ';
    // number of newlines met since the last non-whitespace character  
    int linebreaks = 0;
    // did we meet a backslash escape?  
    boolean escape = false;
    boolean triggerBreak = false;
    for (int i = 0; i < l; i++) {
        char c = str.charAt(i);
        // step one: check if this is the beginning of an HTML tag, comment or  
        // Helma macro.  
        if (c == '<') {
            if (i < (l - 2)) {
                if (!insideMacroTag && ('%' == str.charAt(i + 1))) {
                    // this is the beginning of a Helma macro tag  
                    if (!insideCodeTag) {
                        insideMacroTag = insideTag = true;
                        macroQuoteChar = ' ';
                    }
                } else if (('!' == str.charAt(i + 1)) && ('-' == str.charAt(i + 2))) {
                    // the beginning of an HTML comment?  
                    if (!insideCodeTag) {
                        insideComment = insideTag = ((i < (l - 3)) && ('-' == str.charAt(i + 3)));
                    }
                } else if (!insideTag) {
                    // check if this is a HTML tag.  
                    insideCloseTag = ('/' == str.charAt(i + 1));
                    int tagStart = insideCloseTag ? (i + 2) : (i + 1);
                    int j = tagStart;
                    while ((j < l) && Character.isLetterOrDigit(str.charAt(j))) j++;
                    if ((j > tagStart) && (j < l)) {
                        String tagName = str.substring(tagStart, j).toLowerCase();
                        if ("code".equals(tagName) && insideCloseTag && insideCodeTag) {
                            insideCodeTag = false;
                        }
                        if (((allowedTags == null) || allowedTags.contains(tagName)) && allTags.contains(tagName) && !insideCodeTag) {
                            insideHtmlTag = insideTag = true;
                            htmlQuoteChar = ' ';
                            htmlTagMode = TAG_NAME;
                            exiting = entering;
                            entering = TEXT;
                            if (internalTags.contains(tagName)) {
                                entering = INTERNAL;
                            } else if (blockTags.contains(tagName)) {
                                entering = BLOCK;
                            } else if (semiBlockTags.contains(tagName)) {
                                entering = paragraphs ? BLOCK : SEMIBLOCK;
                            }
                            if (entering > 0) {
                                triggerBreak = !insidePreTag;
                            }
                            if (insideCloseTag) {
                                int t = openTags.search(tagName);
                                if (t == -1) {
                                    i = j;
                                    insideHtmlTag = insideTag = false;
                                    continue;
                                } else if (t > 1) {
                                    for (int k = 1; k < t; k++) {
                                        Object tag = openTags.pop();
                                        if (!emptyTags.contains(tag)) {
                                            ret.append("</");
                                            ret.append(tag);
                                            ret.append(">");
                                        }
                                    }
                                }
                                openTags.pop();
                            } else {
                                openTags.push(tagName);
                            }
                            if ("code".equals(tagName) && !insideCloseTag) {
                                insideCodeTag = true;
                            }
                            if ("pre".equals(tagName)) {
                                insidePreTag = !insideCloseTag;
                            }
                        }
                    }
                }
            }
        }
        if ((triggerBreak || linebreaks > 0) && !Character.isWhitespace(c)) {
            if (!insideTag) {
                exiting = entering;
                entering = TEXT;
                if (exiting >= SEMIBLOCK) {
                    paragraphStart = ret.length();
                }
            }
            if (entering != INTERNAL && exiting != INTERNAL) {
                int swallowBreaks = 0;
                if (paragraphs && (entering != BLOCK || exiting != BLOCK) && (exiting < BLOCK) && (linebreaks > 1) && paragraphStart < ret.length()) {
                    ret.insert(paragraphStart, "<p>");
                    ret.append("</p>");
                    swallowBreaks = 2;
                }
                // treat entering a SEMIBLOCK as entering a TEXT   
                int _entering = entering == SEMIBLOCK ? TEXT : entering;
                for (int k = linebreaks - 1; k >= 0; k--) {
                    if (k >= swallowBreaks && k >= _entering && k >= exiting) {
                        ret.append("<br />");
                    }
                    ret.append(newLine);
                }
                if (exiting >= SEMIBLOCK || linebreaks > 1) {
                    paragraphStart = ret.length();
                }
            }
            linebreaks = 0;
            triggerBreak = false;
        }
        switch(c) {
            case '<':
                if (insideTag) {
                    ret.append('<');
                } else {
                    ret.append("&lt;");
                }
                break;
            case '&':
                // check if this is an HTML entity already,  
                // in which case we pass it though unchanged  
                if ((i < (l - 3)) && !insideCodeTag) {
                    // is this a numeric entity?  
                    if (str.charAt(i + 1) == '#') {
                        int j = i + 2;
                        while ((j < l) && Character.isDigit(str.charAt(j))) j++;
                        if ((j < l) && (str.charAt(j) == ';')) {
                            ret.append("&");
                            break;
                        }
                    } else {
                        int j = i + 1;
                        while ((j < l) && Character.isLetterOrDigit(str.charAt(j))) j++;
                        if ((j < l) && (str.charAt(j) == ';')) {
                            ret.append("&");
                            break;
                        }
                    }
                }
                // we didn't reach a break, so encode the ampersand as HTML entity  
                ret.append("&amp;");
                break;
            case '\\':
                ret.append(c);
                if (insideTag && !insideComment) {
                    escape = !escape;
                }
                break;
            case '"':
            case '\'':
                ret.append(c);
                if (!insideComment) {
                    // check if the quote is escaped  
                    if (insideMacroTag) {
                        if (escape) {
                            escape = false;
                        } else if (macroQuoteChar == c) {
                            macroQuoteChar = ' ';
                        } else if (macroQuoteChar == ' ') {
                            macroQuoteChar = c;
                        }
                    } else if (insideHtmlTag) {
                        if (escape) {
                            escape = false;
                        } else if (htmlQuoteChar == c) {
                            htmlQuoteChar = ' ';
                            htmlTagMode = TAG_SPACE;
                        } else if (htmlQuoteChar == ' ') {
                            htmlQuoteChar = c;
                        }
                    }
                }
                break;
            case '\n':
                if (insideTag || insidePreTag) {
                    ret.append('\n');
                } else {
                    linebreaks++;
                }
                break;
            case '\r':
                if (insideTag || insidePreTag) {
                    ret.append('\r');
                }
                break;
            case '>':
                // For Helma macro tags and comments, we overrule tag balancing,  
                // i.e. we don't require that '<' and '>' be balanced within  
                // macros and comments. Rather, we check for the matching closing tag.  
                if (insideComment) {
                    ret.append('>');
                    insideComment = !((str.charAt(i - 2) == '-') && (str.charAt(i - 1) == '-'));
                } else if (insideMacroTag) {
                    ret.append('>');
                    insideMacroTag = !((str.charAt(i - 1) == '%') && (macroQuoteChar == ' '));
                } else if (insideHtmlTag) {
                    ret.append('>');
                    // only leave HTML tag if quotation marks are balanced  
                    // within that tag.  
                    insideHtmlTag = htmlQuoteChar != ' ';
                    // Check if this is an empty tag so we don't generate an  
                    // additional </close> tag.  
                    if (str.charAt(i - 1) == '/') {
                        // this is to avoid misinterpreting tags like  
                        // <a href=http://foo/> as empty  
                        if (htmlTagMode != TAG_ATT_VAL && htmlTagMode != TAG_ATT_NAME) {
                            openTags.pop();
                        }
                    }
                    exiting = entering;
                    if (exiting > 0) {
                        triggerBreak = !insidePreTag;
                    }
                } else {
                    ret.append("&gt;");
                }
                // check if we still are inside any kind of tag  
                insideTag = insideComment || insideMacroTag || insideHtmlTag;
                insideCloseTag = insideTag;
                break;
            default:
                if (insideHtmlTag && !insideCloseTag) {
                    switch(htmlTagMode) {
                        case TAG_NAME:
                            if (!Character.isLetterOrDigit(c)) {
                                htmlTagMode = TAG_SPACE;
                            }
                            break;
                        case TAG_SPACE:
                            if (Character.isLetterOrDigit(c)) {
                                htmlTagMode = TAG_ATT_NAME;
                            }
                            break;
                        case TAG_ATT_NAME:
                            if (c == '=') {
                                htmlTagMode = TAG_ATT_VAL;
                            } else if (c == ' ') {
                                htmlTagMode = TAG_SPACE;
                            }
                            break;
                        case TAG_ATT_VAL:
                            if (Character.isWhitespace(c) && htmlQuoteChar == ' ') {
                                htmlTagMode = TAG_SPACE;
                            }
                            break;
                    }
                }
                if (c < 128) {
                    ret.append(c);
                } else if ((c >= 128) && (c < 256)) {
                    ret.append(transform[c - 128]);
                } else {
                    ret.append("&#");
                    ret.append((int) c);
                    ret.append(";");
                }
                escape = false;
        }
    }
    // if tags were opened but not closed, close them.  
    int o = openTags.size();
    if (o > 0) {
        for (int k = 0; k < o; k++) {
            Object tag = openTags.pop();
            if (!emptyTags.contains(tag)) {
                ret.append("</");
                ret.append(tag);
                ret.append(">");
            }
        }
    }
    // add remaining newlines we may have collected  
    int swallowBreaks = 0;
    if (paragraphs && entering < BLOCK) {
        ret.insert(paragraphStart, "<p>");
        ret.append("</p>");
        swallowBreaks = 2;
    }
    if (linebreaks > 0) {
        for (int i = linebreaks - 1; i >= 0; i--) {
            if (i >= swallowBreaks && i > exiting) {
                ret.append("<br />");
            }
            ret.append(newLine);
        }
    }
}

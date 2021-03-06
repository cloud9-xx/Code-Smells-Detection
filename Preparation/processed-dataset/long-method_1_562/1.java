/******************************************************************************/
/**
     * Creates new form AnnealingLayoutConfigurationDialog
     */
public AnnealingLayoutSettings(AnnealingLayoutAlgorithm layout, boolean isOptimizationAlgorithm) {
    this.layout = layout;
    // Populate presets 
    Properties[] config = new Properties[2];
    config[0] = new Properties();
    config[0].put(KEY_CONFIG_NAME, "Default Values");
    config[0].put(KEY_INIT_TEMPERATURE, "300.0");
    config[0].put(KEY_MIN_TEMPERATURE, "2.0");
    config[0].put(KEY_MIN_DISTANCE, "50.0");
    config[0].put(KEY_TEMP_SCALE_FACTOR, "0.95");
    config[0].put(KEY_COMPUTE_PERMUTATION, "true");
    config[0].put(KEY_IS_UPHILL_MOVE_ALLOWED, "true");
    config[0].put(KEY_MAX_ROUNDS, "10000");
    config[0].put(KEY_TRIES_PER_CELL, "8");
    config[0].put(KEY_COST_FUNCTION_CONFIG, "111110");
    ArrayList lambda1 = new ArrayList();
    lambda1.add(new Double(1000.0));
    lambda1.add(new Double(100000.0));
    lambda1.add(new Double(0.02));
    lambda1.add(new Double(2000.0));
    lambda1.add(new Double(150.0));
    lambda1.add(new Double(1000000.0));
    config[0].put(KEY_LAMBDA, lambda1);
    Rectangle bounds1 = new Rectangle(0, 0, 1000, 700);
    config[0].put(KEY_BOUNDS, bounds1);
    config[0].put(KEY_LAYOUT_UPDATE_ENABLED, "false");
    config[0].put(KEY_LAYOUT_UPDATE_INIT_TEMPERATURE, "40.0");
    config[0].put(KEY_LAYOUT_UPDATE_MIN_TEMPERATURE, "2.0");
    config[0].put(KEY_LAYOUT_UPDATE_MIN_DISTANCE, "50.0");
    config[0].put(KEY_LAYOUT_UPDATE_TEMP_SCALE_FACTOR, "0.95");
    config[0].put(KEY_LAYOUT_UPDATE_COMPUTE_PERMUTATION, "true");
    config[0].put(KEY_LAYOUT_UPDATE_IS_UPHILL_MOVE_ALLOWED, "true");
    config[0].put(KEY_LAYOUT_UPDATE_MAX_ROUNDS, "10000");
    config[0].put(KEY_LAYOUT_UPDATE_TRIES_PER_CELL, "8");
    config[0].put(KEY_LAYOUT_UPDATE_COST_FUNCTION_CONFIG, "111110");
    config[0].put(KEY_LAYOUT_UPDATE_METHOD, KEY_LAYOUT_UPDATE_METHOD_PERIMETER);
    config[0].put(KEY_LAYOUT_UPDATE_METHOD_NEIGHBORS_DEPTH, "1");
    config[0].put(KEY_LAYOUT_UPDATE_METHOD_PERIMETER_RADIUS, "100.0");
    config[0].put(KEY_LAYOUT_UPDATE_METHOD_PERIMETER_RADIUS_INCREASE, "20.0");
    ArrayList lambdaLU1 = new ArrayList();
    lambdaLU1.add(new Double(1000.0));
    lambdaLU1.add(new Double(100000.0));
    lambdaLU1.add(new Double(0.02));
    lambdaLU1.add(new Double(2000.0));
    lambdaLU1.add(new Double(150.0));
    lambdaLU1.add(new Double(1000000.0));
    config[0].put(KEY_LAYOUT_UPDATE_LAMBDA, lambdaLU1);
    Rectangle boundsLU1 = new Rectangle(0, 0, 1000, 700);
    config[0].put(KEY_LAYOUT_UPDATE_BOUNDS, boundsLU1);
    config[0].put(KEY_LAYOUT_UPDATE_CLUSTERING_ENABLED, "true");
    config[0].put(KEY_LAYOUT_UPDATE_CLUSTERING_FACTOR, "8.0");
    config[0].put(KEY_LAYOUT_UPDATE_CLUSTERING_MOVE_SCALE, "0.1");
    config[1] = new Properties();
    config[1].put(KEY_CONFIG_NAME, "Heavy Values");
    config[1].put(KEY_INIT_TEMPERATURE, "500.0");
    config[1].put(KEY_MIN_TEMPERATURE, "0.5");
    config[1].put(KEY_MIN_DISTANCE, "50.0");
    config[1].put(KEY_TEMP_SCALE_FACTOR, "0.97");
    config[1].put(KEY_COMPUTE_PERMUTATION, "true");
    config[1].put(KEY_IS_UPHILL_MOVE_ALLOWED, "true");
    config[1].put(KEY_MAX_ROUNDS, "10000");
    config[1].put(KEY_TRIES_PER_CELL, "8");
    config[1].put(KEY_COST_FUNCTION_CONFIG, "111111");
    config[1].put(KEY_BOUNDS, "0.0");
    ArrayList lambda2 = new ArrayList();
    lambda2.add(new Double(1000.0));
    lambda2.add(new Double(100000.0));
    lambda2.add(new Double(0.02));
    lambda2.add(new Double(2000.0));
    lambda2.add(new Double(150.0));
    lambda2.add(new Double(1000000.0));
    config[1].put(KEY_LAMBDA, lambda2);
    Rectangle bounds2 = new Rectangle(0, 0, 1000, 700);
    config[1].put(KEY_BOUNDS, bounds2);
    config[1].put(KEY_LAYOUT_UPDATE_ENABLED, "true");
    config[1].put(KEY_LAYOUT_UPDATE_INIT_TEMPERATURE, "40.0");
    config[1].put(KEY_LAYOUT_UPDATE_MIN_TEMPERATURE, "2.0");
    config[1].put(KEY_LAYOUT_UPDATE_MIN_DISTANCE, "50.0");
    config[1].put(KEY_LAYOUT_UPDATE_TEMP_SCALE_FACTOR, "0.97");
    config[1].put(KEY_LAYOUT_UPDATE_COMPUTE_PERMUTATION, "true");
    config[1].put(KEY_LAYOUT_UPDATE_IS_UPHILL_MOVE_ALLOWED, "true");
    config[1].put(KEY_LAYOUT_UPDATE_MAX_ROUNDS, "10000");
    config[1].put(KEY_LAYOUT_UPDATE_TRIES_PER_CELL, "8");
    config[1].put(KEY_LAYOUT_UPDATE_COST_FUNCTION_CONFIG, "111111");
    config[1].put(KEY_LAYOUT_UPDATE_METHOD, KEY_LAYOUT_UPDATE_METHOD_PERIMETER);
    config[1].put(KEY_LAYOUT_UPDATE_METHOD_NEIGHBORS_DEPTH, "2");
    config[1].put(KEY_LAYOUT_UPDATE_METHOD_PERIMETER_RADIUS, "200.0");
    config[1].put(KEY_LAYOUT_UPDATE_METHOD_PERIMETER_RADIUS_INCREASE, "40.0");
    ArrayList lambdaLU2 = new ArrayList();
    lambdaLU2.add(new Double(1000.0));
    lambdaLU2.add(new Double(100000.0));
    lambdaLU2.add(new Double(0.02));
    lambdaLU2.add(new Double(2000.0));
    lambdaLU2.add(new Double(150.0));
    lambdaLU2.add(new Double(1000000.0));
    config[1].put(KEY_LAYOUT_UPDATE_LAMBDA, lambdaLU2);
    Rectangle boundsLU2 = new Rectangle(0, 0, 1000, 700);
    config[1].put(KEY_LAYOUT_UPDATE_BOUNDS, boundsLU2);
    config[1].put(KEY_LAYOUT_UPDATE_CLUSTERING_ENABLED, "true");
    config[1].put(KEY_LAYOUT_UPDATE_CLUSTERING_FACTOR, "12.0");
    config[1].put(KEY_LAYOUT_UPDATE_CLUSTERING_MOVE_SCALE, "0.2");
    isOptimizer = isOptimizationAlgorithm;
    preSetConfigs = config;
    initComponents();
    // TODO: Replace with revert if implemented 
    action_LoadPreSets(0);
}

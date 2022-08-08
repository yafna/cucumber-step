package io.cucumber.junit;

import org.junit.internal.TextListener;
import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;

public class CucumberHacks {
    public static void runScenario(String featureName, String scenarioName) throws InitializationError {
        Cucumber cucumber2 = new Cucumber(ExplicitFeaturePath.class);

        RunListener listener = new TextListener(System.out) {
            @Override
            public void testFinished(Description description) throws Exception {
                super.testFinished(description);
                System.out.println(" feature run description = " + description);
            }
        };
        RunNotifier notifier = new RunNotifier();
        notifier.addListener(listener);

        String combinedDescription = scenarioName + "(" + featureName + ")";
        for (ParentRunner<?> feature : cucumber2.getChildren()) {
            if (featureName.equalsIgnoreCase(feature.getDescription().getDisplayName())) {
                for (PickleRunners.PickleRunner scenario : ((FeatureRunner) feature).getChildren()) {
                    if (combinedDescription.equalsIgnoreCase(scenario.getDescription().getDisplayName())) {
                        ((FeatureRunner) feature).runChild(scenario, notifier);
                    }
                }
            }
        }
    }

    public static void runFeature(String featureName) throws InitializationError {
        Cucumber cucumber2 = new Cucumber(ExplicitFeaturePath.class);
        RunListener listener = new TextListener(System.out) {
            @Override
            public void testFinished(Description description) throws Exception {
                super.testFinished(description);
                System.out.println(" feature run description = " + description);
            }
        };
        RunNotifier notifier = new RunNotifier();
        notifier.addListener(listener);

        for (ParentRunner<?> feature : cucumber2.getChildren()) {
            if (featureName.equalsIgnoreCase(feature.getDescription().getDisplayName())) {
                feature.run(notifier);
            }
        }
    }

    @CucumberOptions(features = "classpath:some/test")
    public static class ExplicitFeaturePath {

    }
}

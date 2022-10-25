package CaisseDeconnectee.Backend;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.jbehave.core.ConfigurableEmbedder;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.testng.annotations.Test;
import static org.jbehave.core.io.CodeLocations.*;
public class storyRunner extends ConfigurableEmbedder {

public Embedder embedder;


@Override
@Test

public void run() {

embedder = configuredEmbedder();

embedder.configuration();

System.out.println("I am run method"); 

String storyPath="myFirstStory.story";
System.out.println("here");

/*List<String> storyPaths = new
StoryFinder().findPaths(codeLocationFromClass(this.getClass()),
"**///*.story", null);
System.out.println("here2");

    StoryFinder finder = new StoryFinder();
    List<String> storyPaths1 =  finder.findPaths(codeLocationFromClass(this.getClass()).getFile(), Arrays.asList("**/*.story"), null);
System.out.println("hereeeeee" +storyPaths1);



embedder.runStoriesAsPaths (Collections.singletonList(storyPaths1.get(0)));

}

public Configuration configuration() { return new MostUsefulConfiguration().useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(org.jbehave.core.reporters.Format.CONSOLE,org.jbehave.core.reporters.Format.HTML));}

public InjectableStepsFactory stepsFactory(){

return new InstanceStepsFactory(configuration(), new steps());
}}
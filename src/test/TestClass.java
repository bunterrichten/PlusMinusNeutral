package test;

import DateizugriffeV1.FileUtility;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.jupiter.api.Assertions;

import static DateizugriffeV1.FileUtility.readFileLineByLine;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import plusminus.PlusMinus;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

    @BeforeEach
    void setup() {
        List<String> liste = FileUtility.readFileLineByLine("ads.aa");
    }

    @Theory
    @ParameterizedTest
    @MethodSource("provideParameters")
    @DisplayName("check all texts")
    void test5(int res, String one) {

        double test = PlusMinus.plusMinus(one);

        int end = 0;
        if (test > 0.2)
            end = 1;
        else if (test < -0.2)
            end = -1;
        else
            end = 0;


        Assertions.assertEquals(res, end);
    }


    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(1, "In the very start the movie seems so innocent and a little silly. The colors are all bright. The humor though is really entertaining and i like that the Germans can joke about this topic themselves. As the movie goes on we see a lot of footage of ordinary Germans saluting Hitler and complaining about the immigrants, it connects really good with the time we live in. The movie gets more and more serious, and the main character finds out it's the real Hitler. I think the well made transition from being all innocent and humorous describes Nazi Germany. No one thought it would go this far. Really touched me even though i've seen quite a lot of movies about Nazi Germany. 9/10"),
                Arguments.of(-1, "This movie fails on all levels! It's neither an entertaining comedy nor an intellectually deep movie and even less a warning sign where it wd be appropriate! To me it felt like a fast cooked set of superficial plotting deemed to be instrumentalised for political reasons without any justification for that!"),
                Arguments.of(-1, "The movie is definitely different.. Starts as document-like alternative reality, tries to behave as if real public interviews were done and movie shot by amateurs, sometimes attempts to philosophize another time it's an absurd borat-like comedy.. The motive could have been written up in many various ways.. Nevertheless, I did not get the message of the movie.. if it even had one... After all, it was not that funny actually.. Maybe you one can try finding some hidden \"value\" that is not there.. but still it is nothing for me.. A stupid commedy would be much more acceptable to me..."),
                Arguments.of(0, "The idea behind this movie - Hitler finding himself in the 21st century and reacting to (and using) modern day Germans and new technology - is one that's both very intriguing and full of potential satire and humor. However, the end results are kind of a mess. On the positive side, the movie's dark attitude to the drama sometimes really hits the target, revealing that some evil opinions are still in a lot of German citizens and could be reactivated easily, as well as giving a plausible look as to what Hitler would use in this day and age (such as the Internet) to get what he wanted. At the same time there is plenty of absurdity that prevent things from being so black that all the entertainment is sucked out."),
                Arguments.of(0, "This had so much promise. Going in to it I was expecting a comedy, some satire, maybe a political message. it ends up being boring. There are so many times in this movie that I just thought, why has nobody investigated this guy. The plausibility of a person impersonating Hitler being able to get so many people behind his message is just ridiculous. People are radical yes, but eventually someone would run his fingerprints or things like that and realize he is the real one and he would be locked up or executed. It's a cool concept but it's handled poorly which makes me really sad that this movie isn't entertaining."),
                Arguments.of(0, "Quite fun to watch, but not logical, especially the basic ones. Since it mocks a most hated person in the human history, there's no issues on portraying him in whatever angle they wanted, because nobody cares. Yet the film talked some serious current issues of Germany."),
                Arguments.of(0, "The scary thing about Hitler is that he's a mirror of people's views. He's not a human. He's an actor, a storyteller. People ask him in the film if he ever breakes character. He doesn't. He's Hitler. Hitler is a force amongst the people from places cursed with a historicistic culture of downplayed racism, imperialism, oppression and fascism. And this is not only Germany, but the entirety of the west. Behind the masks, in the ugly subconscious. That's where Hitler is. If he came back, this film argues, people would not realize this horrific truth but still follow him. Therefore, in imperialist society nazism is consistent as something that only needs a spearhead to show itself."),
                Arguments.of(1, "This is definitely a great work that shows the front and the back. On the surface, it is just a series of events that happened to Hitler's resurrection. But in fact, it uses the seemingly absurd plot to seriously talk about national politics and nationalism. The film is full of nationalist discrimination and prejudice. It is ruthlessly exposed and licked the scars of history, mocking this bad history, but the purpose is to express the concerns and concerns about the current situation of the people in the country. The whole film says that Hitler needs the people. And the ending point is exactly what the people need Hitler. He is just a genius born from the needs of the people. He is full of vision and highly provocative. Regardless of ancient and modern times, he is just a miniature of the hearts of millions of people. The history is right and wrong, but it is always a fault Do contemporary people need to be vigilant? In general, the irony of the perfect score is perfect. If Hitler's first half of the plot can clearly express Hitler's personal characteristics, it is even better. The segment that imitates the destruction of the empire is definitely the most important point of the film.")
        );
    }
}

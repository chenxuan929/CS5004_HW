import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

import org.junit.Before;
import org.junit.Test;
import questionnaire.Likert;
import questionnaire.Question;
import questionnaire.Questionnaire;
import questionnaire.QuestionnaireImpl;
import questionnaire.ShortAnswer;
import questionnaire.YesNo;

/**
 * Test for Questionnaire class.
 */
public class QuestionnaireTest {
  private Questionnaire questionnaire;

  /**
   * Set up a new object to test method.
   */
  @Before
  public void setUp() {
    questionnaire = new QuestionnaireImpl();
  }

  /**
   * Test add question method and get question method.
   */
  @Test
  public void testAddandGetQuestion() {
    Question q1 = new YesNo("1", false);
    Question q2 = new ShortAnswer("2", true);
    Question q3 = new Likert("3", true);

    questionnaire.addQuestion("Q1", q1);
    questionnaire.addQuestion("I'mQ2",q2);
    questionnaire.addQuestion("Hi_q3", q3);

    assertEquals(q1, questionnaire.getQuestion("Q1"));
    assertEquals(q2, questionnaire.getQuestion("I'mQ2"));
    assertEquals(q3, questionnaire.getQuestion("Hi_q3"));
  }


  /**
   * Test exception to addQuestion method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddQuestionException() {
    questionnaire.addQuestion(null, new YesNo("1", true));
    questionnaire.addQuestion(null, new ShortAnswer("2", false));
    questionnaire.addQuestion("", new Likert("3", false));
    questionnaire.addQuestion("4", null);
    Question newQ = new YesNo("1", false);
    questionnaire.addQuestion("q1", newQ);
    questionnaire.addQuestion("q1", new ShortAnswer("2", false));
  }

  /**
   * Test removeQuestion method.
   */
  @Test
  public void testRemoveQuestion() {
    Question q1 = new YesNo("1", false);
    Question q2 = new ShortAnswer("2", false);
    Question q3 = new Likert("3", true);
    questionnaire.addQuestion("q1", q1);
    questionnaire.addQuestion("q2", q2);
    questionnaire.addQuestion("q3", q3);
    assertEquals(q2, questionnaire.getQuestion(2));
    questionnaire.removeQuestion("q1");
    assertEquals(q3, questionnaire.getQuestion(2));
    assertEquals(q2, questionnaire.getQuestion(1));
    questionnaire.removeQuestion("q2");
    assertEquals(q3, questionnaire.getQuestion(1));
  }

  /**
   * Test IllegalArgument exception to removeQuestion method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveQuestionIllegal() {
    questionnaire.removeQuestion(null);
  }

  /**
   * Test NoSuchElement exception to removeQuestion method.
   */
  @Test(expected = NoSuchElementException.class)
  public void testRemoveQuestionNoSuch() {
    questionnaire.removeQuestion("none");
  }

  /**
   * Test get question method.
   */
  @Test
  public void testGetQuestion() {
    Question q1 = new YesNo("1", false);
    Question q2 = new ShortAnswer("2", false);
    Question q3 = new Likert("3", true);
    questionnaire.addQuestion("h", q1);
    questionnaire.addQuestion("i", q2);
    questionnaire.addQuestion("!", q3);

    assertEquals(q1, questionnaire.getQuestion(1));
    assertEquals(q2, questionnaire.getQuestion(2));
    assertEquals(q3, questionnaire.getQuestion(3));
  }

  /**
   * Test filter method.
   */
  @Test
  public void testFilteredQuestions() {
    QuestionnaireImpl questionnaire = new QuestionnaireImpl();
    Question q1 = new ShortAnswer("1", true);
    Question q2 = new ShortAnswer("2", false);
    Question q3 = new ShortAnswer("3", false);
    questionnaire.addQuestion("h", q1);
    questionnaire.addQuestion("i", q2);
    questionnaire.addQuestion("!", q3);
    Questionnaire filteredQuestionnaire = questionnaire.filter(Question::isRequired);
    assertEquals(1, filteredQuestionnaire.getRequiredQuestions().size());
    assertEquals(0, filteredQuestionnaire.getOptionalQuestions().size());
    assertEquals(2, questionnaire.getOptionalQuestions().size());
    assertEquals(1, questionnaire.getRequiredQuestions().size());
  }

  /**
   * Test sort method.
   */
  @Test
  public void testSort() {
    QuestionnaireImpl questionnaire = new QuestionnaireImpl();
    Question q1 = new ShortAnswer("How are u", true);
    Question q2 = new ShortAnswer("are u hungry", true);
    Question q3 = new ShortAnswer("What time is it", true);
    questionnaire.addQuestion("hi", q1);
    questionnaire.addQuestion("eat", q2);
    questionnaire.addQuestion("time", q3);
    Comparator<Question> comp = (a, b) -> a.getPrompt().compareTo(b.getPrompt());
    questionnaire.sort(comp);
    assertEquals("How are u",
        questionnaire.getQuestion(1).getPrompt());
    assertEquals("What time is it",
        questionnaire.getQuestion(2).getPrompt());
    assertEquals("are u hungry",
        questionnaire.getQuestion(3).getPrompt());
  }

  /**
   * Test fold method.
   */
  @Test
  public void testFold() {
    QuestionnaireImpl questionnaire = new QuestionnaireImpl();
    Question q1 = new ShortAnswer("How are u", true);
    Question q2 = new ShortAnswer("are u hungry", true);
    Question q3 = new ShortAnswer("What time is it", true);
    questionnaire.addQuestion("hi", q1);
    questionnaire.addQuestion("eat", q2);
    questionnaire.addQuestion("time", q3);
    BiFunction<Question, String, String> bf = (a, b) -> b
        + a.getPrompt()
        + ": "
        + a.getAnswer() + "\n";
    assertEquals("How are u: \n"
        + "are u hungry: \n"
        + "What time is it: \n", questionnaire.fold(bf, ""));
  }

  /**
   * Test toString method.
   */
  @Test
  public void testToString() {
    Question q1 = new ShortAnswer("How are u", true);
    q1.answer("good");
    Question q2 = new ShortAnswer("are u hungry", true);
    q2.answer("no");
    Question q3 = new ShortAnswer("What time is it", true);
    q3.answer("9pm");
    QuestionnaireImpl questionnaire = new QuestionnaireImpl();
    questionnaire.addQuestion("hi", q1);
    questionnaire.addQuestion("eat", q2);
    questionnaire.addQuestion("time", q3);
    assertEquals("Question: How are u\n\nAnswer: good\n\n"
        + "Question: are u hungry\n\nAnswer: no\n\n"
        + "Question: What time is it\n\nAnswer: 9pm", questionnaire.toString());
  }
}
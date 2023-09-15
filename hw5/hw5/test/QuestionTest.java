import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import questionnaire.Likert;
import questionnaire.Question;
import questionnaire.ShortAnswer;
import questionnaire.YesNo;



/**
 * Test class for question interface.
 */
public class QuestionTest {
  private Question yesNoQuestion;
  private Question shortAnswerQuestion;
  private Question likertQuestion;

  /**
   * Set up.
   */
  @Before
  public void setUp() {
    yesNoQuestion = new YesNo("1 + 1 = 2", true);
    shortAnswerQuestion = new ShortAnswer("How are u", true);
    likertQuestion = new Likert("how hungry r u now", false);
  }

  /**
   * Test get prompt method.
   */
  @Test
  public void testGetPrompt() {
    assertEquals("1 + 1 = 2", yesNoQuestion.getPrompt());
    assertEquals("How are u", shortAnswerQuestion.getPrompt());
    assertEquals("how hungry r u now", likertQuestion.getPrompt());
  }

  /**
   * Test is required method.
   */
  @Test
  public void testIsRequired() {
    assertTrue(yesNoQuestion.isRequired());
    assertTrue(shortAnswerQuestion.isRequired());
    assertFalse(likertQuestion.isRequired());
  }

  /**
   * Test answer IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testExceptionAnswer() {
    yesNoQuestion.answer(null);
    yesNoQuestion.answer("yyyes");
    shortAnswerQuestion.answer(null);
    likertQuestion.answer(null);
    likertQuestion.answer("no");
  }

  /**
   * Test get answer method.
   */
  @Test
  public void testGetAnswer() {
    yesNoQuestion.answer("YEs");
    assertEquals("YEs", yesNoQuestion.getAnswer());
    shortAnswerQuestion.answer("1111");
    assertEquals("1111", shortAnswerQuestion.getAnswer());
    likertQuestion.answer("Neither Agree Nor Disagree");
    assertEquals("Neither Agree Nor Disagree", likertQuestion.getAnswer());
  }

  /**
   * Test copy method.
   */
  @Test
  public void testCopy() {
    Question q1 = new YesNo("1 + 1 = 2", false);
    q1.answer("yes");
    Question q2 = q1.copy();
    q2.answer("no");
    assertNotEquals(q1.getAnswer(), q2.getAnswer());
    Question q3 = q1.copy();
    q3.answer("yes");
    assertEquals(q1.getAnswer(), q3.getAnswer());
    Question q4 = new Likert("how hungry r u now", true);
    q4.answer("Neither Agree Nor Disagree");
    Question q5 = q4.copy();
    assertEquals(q1.getAnswer(), q3.getAnswer());
  }
}

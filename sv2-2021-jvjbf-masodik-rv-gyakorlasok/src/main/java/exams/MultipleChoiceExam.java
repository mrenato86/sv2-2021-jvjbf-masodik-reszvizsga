package exams;

public class MultipleChoiceExam extends Exam {

    public static final int PASSING_PERCENT = 51;

    public MultipleChoiceExam(long studentId, String topic) {
        super(studentId, topic);
    }

    public MultipleChoiceExam(long studentId, String topic, int maxPoints) {
        super(studentId, topic, maxPoints);
    }

    @Override
    public void calculateExamResult(int actualPoints) {
        checkActualPoints(actualPoints);
        double passingLimit = PASSING_PERCENT / 100. * getMaxPoints();
        setExamResult(actualPoints < passingLimit ? ExamResult.NOT_PASSED : ExamResult.PASSED);
    }

}

package exams;

import java.util.List;

public class PracticeExam extends Exam {

    private static final int PASS_PERCENT = 51;
    private static final int OK_PERCENT = 76;

    public PracticeExam(long studentId, String topic, List<Integer> points) {
        super(studentId, topic);
        setMaxPoints(calculateMaxPoint(points));
        checkMaxPoints();
    }

    private void checkMaxPoints() {
        if (getMaxPoints() < 10 || getMaxPoints() > 150) {
            throw new IllegalArgumentException("Maximum points should be between 10 and 150! Actual:" + getMaxPoints());
        }
    }

    private int calculateMaxPoint(List<Integer> points) {
        int sum = 0;
        for (int point : points) {
            sum += point;
        }
        return sum;
    }

    @Override
    public void calculateExamResult(int actualPoints) {
        checkActualPoints(actualPoints);
        int result = 100 * actualPoints / getMaxPoints();
        if (result < PASS_PERCENT) {
            setExamResult(ExamResult.NOT_PASSED);
        } else if (result < OK_PERCENT) {
            setExamResult(ExamResult.OK);
        } else {
            setExamResult(ExamResult.PERFECT);
        }
    }
}

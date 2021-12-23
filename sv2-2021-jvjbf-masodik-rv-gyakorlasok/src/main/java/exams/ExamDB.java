package exams;

import java.util.ArrayList;
import java.util.List;

public class ExamDB {

    private final List<Exam> exams = new ArrayList<>();

    public List<Exam> getExams() {
        return new ArrayList<>(exams);
    }

    public void addExam(Exam exam, int actualPoints) {
        exam.calculateExamResult(actualPoints);
        exams.add(exam);
    }

    public int countPassedExams() {
        int passedExams = 0;
        for (Exam exam : exams) {
            if (exam.getExamResult() != (ExamResult.NOT_PASSED)) {
                passedExams++;
            }
        }
        return passedExams;
    }

    public List<Exam> findById(long studentId) {
        List<Exam> examsById = new ArrayList<>();
        for (Exam exam : exams) {
            if (exam.getStudentId() == studentId) {
                examsById.add(exam);
            }
        }
        return examsById;
    }

    public List<String> findTopicByPrefix(String prefix) {
        List<String> topicByPrefix = new ArrayList<>();
        for (Exam exam : exams) {
            String actualTopic = exam.getTopic();
            if (actualTopic.startsWith(prefix) && !topicByPrefix.contains(actualTopic)) {
                topicByPrefix.add(actualTopic);
            }
        }
        return topicByPrefix;
    }
}

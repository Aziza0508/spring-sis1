package kz.kbtu.sis7.producer;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import kz.kbtu.sis7.producer.soap.GetStudentRequest;
import kz.kbtu.sis7.producer.soap.GetStudentResponse;
import kz.kbtu.sis7.producer.soap.Student;

@Endpoint
public class StudentEndpoint {

    private static final String NAMESPACE_URI = "http://kbtu.kz/sis7/students";

    private final StudentRepository repository;

    public StudentEndpoint(StudentRepository repository) {
        this.repository = repository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStudentRequest")
    @ResponsePayload
    public GetStudentResponse getStudent(@RequestPayload GetStudentRequest request) {
        Student student = repository.findById(request.getId());
        GetStudentResponse response = new GetStudentResponse();
        if (student != null) {
            response.setStudent(student);
        }
        return response;
    }
}

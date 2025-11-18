package kz.kbtu.sis7.consumer;

import kz.kbtu.sis7.consumer.soap.GetStudentRequest;
import kz.kbtu.sis7.consumer.soap.GetStudentResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class StudentClient extends WebServiceGatewaySupport {

    public GetStudentResponse getStudent(int id) {
        GetStudentRequest request = new GetStudentRequest();
        request.setId(id);
        return (GetStudentResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }
}
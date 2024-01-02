package com.mycompany;

import com.mycompany.hr.service.HumanResourceService;
import com.mycompany.hr.ws.HolidayEndpoint;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

class HolidayEndpointTest {

    private Document holidayRequest;

    private HolidayEndpoint endpoint;

    private HumanResourceService serviceMock;

    private Calendar startCalendar;

    private Calendar endCalendar;


    @BeforeEach
    public void setUp() throws IOException, JDOMException {
        serviceMock = Mockito.mock(HumanResourceService.class);
        SAXBuilder builder = new SAXBuilder();
        InputStream is = getClass().getResourceAsStream("/holidayRequest.xml");

        try {
            holidayRequest = builder.build(is);
        } finally {
            is.close();
        }

        endpoint = new HolidayEndpoint(serviceMock);
        startCalendar = Calendar.getInstance();
        startCalendar.clear();
        startCalendar.set(2006, Calendar.JULY, 3);
        endCalendar = Calendar.getInstance();
        endCalendar.clear();
        endCalendar.set(2006, Calendar.JULY, 7);

    }

    @Test
    @DisplayName("Testing mocked service")
    void handleHolidayRequest() throws Exception {
		serviceMock.bookHoliday(startCalendar.getTime(), endCalendar.getTime(), "Jhon Doe");

		endpoint.handleHolidayRequest(holidayRequest.getRootElement());

		Mockito.verify(serviceMock);
    }

    @Test
    void contextLoads() {
    }

}

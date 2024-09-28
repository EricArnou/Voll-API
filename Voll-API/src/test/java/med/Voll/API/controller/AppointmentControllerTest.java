package med.Voll.API.controller;

import med.Voll.API.domain.appointment.RegisterAppointmentDto;
import med.Voll.API.domain.appointment.ReturnAppointmentDto;
import med.Voll.API.domain.doctor.Specialty;
import med.Voll.API.service.AppointmentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static med.Voll.API.TestAssistant.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@WithMockUser
class AppointmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppointmentService appointmentService;

    @Autowired
    private JacksonTester<RegisterAppointmentDto> registerAppointmentDtoJacksonTester;

    @Autowired
    private JacksonTester<ReturnAppointmentDto> returnAppointmentDtoJacksonTester;

    @Test
    void whenPostMethodIsEmptyExpectBadRequestStatus() throws Exception {
        var response = mockMvc.perform(post("/consultas"))
                .andReturn()
                .getResponse();

        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void whenPostMethodHasCorrectJsonExpectContentBack() throws Exception {

        var returnAppointmentDto = new ReturnAppointmentDto(null, DOCTOR_ID_1, PATIENT_ID_1, NEXT_MONDAY_AT_10AM);

        when(appointmentService.scheduleAnAppointment(any())).thenReturn(ResponseEntity.ok(returnAppointmentDto));

        var response = mockMvc.perform(post("/consultas")
                .contentType(MediaType.APPLICATION_JSON)
                    .content(registerAppointmentDtoJacksonTester.write(new RegisterAppointmentDto(
                            DOCTOR_ID_1,
                            PATIENT_ID_1,
                            NEXT_MONDAY_AT_10AM,
                            Specialty.CARDIOLOGIA)
                    ).getJson())
                ).andReturn()
                .getResponse();

        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        var expectJson = returnAppointmentDtoJacksonTester.write(
            returnAppointmentDto
        ).getJson();

        Assertions.assertThat(response.getContentAsString()).isEqualTo(expectJson);
    }
}
package com.genhijra.api.test;

import com.genhijra.api.entity.master.Nasabah;
import com.genhijra.api.util.GenHijraCommonResponse;
import com.genhijra.api.controller.NasabahController;
import com.genhijra.api.dao.master.INasabahDAO;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class NasabahControllerTest
{
    @InjectMocks
    NasabahController nasabahController;

    @Mock
            @Autowired
    INasabahDAO nasabahDAO;

    @Test
    public void testAddNasabah()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Nasabah nasabah = new Nasabah();
        nasabah.setId(100);
        nasabah.setAlamat("Depok");
        nasabah.setNama("Idris");
        nasabah.setNoRekening("123");
        nasabah.setTtl("2010-02-20");

        //when(nasabahDAO.createNasabah(any(Nasabah.class))).thenReturn(nasabah);

        Nasabah nasabahToAdd = new Nasabah();
        nasabahToAdd.setAlamat("Depok");
        nasabahToAdd.setNama("Idris");
        nasabahToAdd.setNoRekening("123");
        nasabahToAdd.setTtl("2010-02-20");
        ResponseEntity<GenHijraCommonResponse> responseEntity = nasabahController.createBook(nasabahToAdd);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }

//    @Test
//    public void testFindAll()
//    {
//        // given
//        Employee employee1 = new Employee("Lokesh", "Gupta", "howtodoinjava@gmail.com");
//        Employee employee2 = new Employee("Alex", "Gussin", "example@gmail.com");
//        List<Employee> list = new ArrayList<Employee>();
//        list.addAll(Arrays.asList(employee1, employee2));
//
//        when(employeeRepository.findAll()).thenReturn(list);
//
//        // when
//        Employees result = employeeController.getEmployees();
//
//        // then
//        assertThat(result.getEmployeeList().size()).isEqualTo(2);
//
//        assertThat(result.getEmployeeList().get(0).getFirstName())
//                .isEqualTo(employee1.getFirstName());
//
//        assertThat(result.getEmployeeList().get(1).getFirstName())
//                .isEqualTo(employee2.getFirstName());
//    }
}


package no.acntech.project101.web.employee.resources.converter;

import no.acntech.project101.company.Company;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import no.acntech.project101.employee.Employee;
import no.acntech.project101.web.employee.resources.EmployeeDto;

@Component
public class EmployeeDtoConverter implements Converter<Employee, EmployeeDto> {

    @Override
    public EmployeeDto convert(final Employee source) {
        Company company = source.getCompany();
        return new EmployeeDto(source.getId(), source.getFirstName(), source.getLastName(), source.getDateOfBirth(), company == null ? null : company.getId());
    }

}

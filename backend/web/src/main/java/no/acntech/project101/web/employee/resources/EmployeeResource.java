package no.acntech.project101.web.employee.resources;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("employees")
//TODO This is a REST controler and should receive request on path employees
public class EmployeeResource {

    //TODO The constructor needs to accept the required dependencies and assign them to class variables
    public EmployeeResource() {
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> findAll() {
        EmployeeDto employeeDto = new EmployeeDto(12345L, "Dag Johnsrud", "Kristiansen",
                LocalDate.of(1995, 06, 15), 1337L);
        EmployeeDto bilal = new EmployeeDto(2345L, "Bilal", "Matchoman",
                LocalDate.of(1995, 12, 6), 1338L);
        final List<EmployeeDto> liste = new ArrayList<EmployeeDto>();
        liste.add(employeeDto);
        liste.add(bilal);
        //TODO create a GET endpoint find all employees in the database and return them
        return ResponseEntity.ok(liste);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> findById() {
        EmployeeDto employeeDto = new EmployeeDto(12345L, "Dag Johnsrud", "Kristiansen",
                LocalDate.of(1995, 06, 15), 1337L);
        // TODO create a GET endpoint that fetches a spesific employee based on its ID
        return ResponseEntity.ok (employeeDto);
    }

    @PostMapping
    public ResponseEntity createEmployee(@RequestBody final EmployeeDto employeedto) {
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(1337L)
                .toUri();
        //TODO Create a POST endpoint that accepts an employeeDTO and saves it in the database

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping
    public ResponseEntity deleteEmployee() {
        // TODO Create a DELETE endpoint that deletes a specific employee
        return null;
    }

    @PatchMapping
    public ResponseEntity updateEmployee() {
        //TODO Create a PATCH endpoint that updates an employee with new values
        return null;
    }
}

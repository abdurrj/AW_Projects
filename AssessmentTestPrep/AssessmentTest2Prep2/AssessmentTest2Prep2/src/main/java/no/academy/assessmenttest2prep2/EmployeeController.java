package no.academy.assessmenttest2prep2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
class EmployeeController {

    public List<EmployeeVO> employeeVOList = new ArrayList<>();

    /*
       Make a GetMapping on "/employee" where it takes in an "id" that is not required, and returns the employee with that id, else returns nothing.
     */
    @GetMapping("/employee")
    public EmployeeVO employeePage(
            @RequestParam(required = false, defaultValue="")String id

    ){

        return employeeVOList.stream()
                // Applying filter on employeeVO objects
                // and checking if employeeNumber is same as provided id
                .filter(employeeVO -> employeeVO.getEmployeeNumber().equals(id))

                // find and return any match, or return null if no match found
                // it returns the type of object we're working on
                .findAny().orElse(null);

// With for loop
/*
        for (EmployeeVO e : employeeVOList){
            if (e.getEmployeeNumber().equals(id)){
                return e;
            }
        }
        return null;*/
    }


    /*
        Make a GetMapping on "/employees" where it returns a list of all employees.
     */
    @GetMapping("/employees")
    public List<EmployeeVO> listOfEmployees(){
        return employeeVOList;
    }

    /*
        Make a GetMapping on "/employeesNumber" where it returns the number of employees.
     */
    @GetMapping("/employeesNumber")
    public int numberOfEmployees(){
        return employeeVOList.size();
    }


    /*
        Make a PostMapping on "/employee" where it takes in an EmployeeVO, adds it, and returns a responseEntity with the created user and status created.
        Hint: RequestBody, ResponseEntity
     */
    @PostMapping("/employee")
    public ResponseEntity<EmployeeVO> postEmployeeMethod(
            @RequestBody EmployeeVO employeeVO
            ){
        employeeVOList.add(employeeVO);
        return new ResponseEntity<EmployeeVO>(employeeVO, HttpStatus.CREATED);
    }


    /*
        Make a DeleteMapping on "/deleteAllEmployees" that deletes all employees.
     */
    @DeleteMapping("/deleteAllEmployees")
    public void deleteAllEmployees(){
        employeeVOList.clear();
    }

}

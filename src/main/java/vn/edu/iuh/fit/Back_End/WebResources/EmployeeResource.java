package vn.edu.iuh.fit.Back_End.WebResources;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.Back_End.convertes.JacksonConfigMapper;
import vn.edu.iuh.fit.Back_End.entities.Employee;
import vn.edu.iuh.fit.Back_End.reponsitories.EmployeeReponsitory;

@Path("/employee")
public class EmployeeResource {
    private final EmployeeReponsitory employeeReponsitory = new EmployeeReponsitory();
    private final JacksonConfigMapper jacksonConfigMapper = new JacksonConfigMapper();

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getEmployee(@PathParam("id") long ids){
        Employee employee = employeeReponsitory.getOne(ids);
        if (employee != null){
            try {
                String json = jacksonConfigMapper.getContext(Employee.class).writeValueAsString(employee);
                return Response.ok(json).build();
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @GET
    @Produces("application/json")
    public Response getAll(){
        try {
            String json = jacksonConfigMapper.getContext(Employee.class).writeValueAsString(employeeReponsitory.getAllEmplyees());
            return Response.ok(json).build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/{ids}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response update(@PathParam("ids") long id, Employee employee){
        employee.setId(id);
        if (employeeReponsitory.updateEmployee(employee)){
            return Response.ok(employee).build();
        }
        return Response.ok().build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Employee employee){
        return  Response.ok(employeeReponsitory.insertEmployee(employee)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long ids){
        if (employeeReponsitory.deleteEmployee(employeeReponsitory.getOne(ids))){
            return Response.ok(true).build();
        }
        return Response.ok(false).build();
    }

}


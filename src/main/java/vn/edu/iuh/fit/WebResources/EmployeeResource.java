package vn.edu.iuh.fit.WebResources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.entities.Employee;
import vn.edu.iuh.fit.reponsitories.EmployeeReponsitory;

@Path("/employee")
public class EmployeeResource {
    private final EmployeeReponsitory employeeReponsitory = new EmployeeReponsitory();
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getEmployee(@PathParam("id") long ids){
        Employee employee = employeeReponsitory.getOne(ids);
        if (employee != null){
            return Response.ok(employee).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @GET
    @Produces("application/json")
    public Response getAll(){
        return Response.ok(employeeReponsitory.getAllEmplyees()).build();
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
        employeeReponsitory.insertEmployee(employee);
        return  Response.ok(employee).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long ids){
        if (employeeReponsitory.deleteEmployee(employeeReponsitory.getOne(ids))){
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}


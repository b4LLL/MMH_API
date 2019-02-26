/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import MMHPackage.UserDiary;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jonathon
 */
@Stateless
@Path("mmhpackage.userdiary")
public class UserDiaryFacadeREST extends AbstractFacade<UserDiary> {

    RunServerInterface ServerInterface = new RunServerInterface();

    @PersistenceContext(unitName = "MMH_APIPU")
    private EntityManager em;

    public UserDiaryFacadeREST() {
        super(UserDiary.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(UserDiary entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, UserDiary entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public UserDiary find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<UserDiary> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<UserDiary> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @GET
    @Path("SetDiaryEntry/{UserID}/{DiaryEntryOne}/{DiaryEntryTwo}/{DiaryEntryThree}/{DiaryEntryFour}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String SetDiaryEntry(@PathParam("UserID") String UserID,
                @PathParam("DiaryEntryOne") String DiaryEntryOne,
                @PathParam("DiaryEntryTwo") String DiaryEntryTwo,
                @PathParam("DiaryEntryThree") String DiaryEntryThree,
                @PathParam("DiaryEntryFour") String DiaryEntryFour)
    {
        String[] Parameters = new String[5];
        Parameters[0] = UserID;
        Parameters[1] = DiaryEntryOne;
        Parameters[2] = DiaryEntryTwo;
        Parameters[3] = DiaryEntryThree;
        Parameters[4] = DiaryEntryFour;
        Parameters[0] = ServerInterface.SanitiseURL(Parameters[0]);
        Parameters[1] = ServerInterface.SanitiseURL(Parameters[1]);
        Parameters[2] = ServerInterface.SanitiseURL(Parameters[2]);
        Parameters[3] = ServerInterface.SanitiseURL(Parameters[3]);
        Parameters[4] = ServerInterface.SanitiseURL(Parameters[4]);
        return ServerInterface.ConnectToServer("SetDiaryEntry", Parameters);
    }

    @GET
    @Path("UpdateDiaryEntry/{UserDiaryID}/{UserID}/{DiaryEntryOne}/{DiaryEntryTwo}/{DiaryEntryThree}/{DiaryEntryFour}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String UpdateDiaryEntry(@PathParam("UserDiaryID") String UserDiaryID,
                @PathParam("UserID") String UserID,
                @PathParam("DiaryEntryOne") String DiaryEntryOne,
                @PathParam("DiaryEntryTwo") String DiaryEntryTwo,
                @PathParam("DiaryEntryThree") String DiaryEntryThree,
                @PathParam("DiaryEntryFour") String DiaryEntryFour)
    {
        String[] Parameters = new String[6];
        Parameters[0] = UserDiaryID;
        Parameters[1] = UserID;
        Parameters[2] = DiaryEntryOne;
        Parameters[3] = DiaryEntryTwo;
        Parameters[4] = DiaryEntryThree;
        Parameters[5] = DiaryEntryFour;
        Parameters[0] = ServerInterface.SanitiseURL(Parameters[0]);
        Parameters[1] = ServerInterface.SanitiseURL(Parameters[1]);
        Parameters[2] = ServerInterface.SanitiseURL(Parameters[2]);
        Parameters[3] = ServerInterface.SanitiseURL(Parameters[3]);
        Parameters[4] = ServerInterface.SanitiseURL(Parameters[4]);
        Parameters[5] = ServerInterface.SanitiseURL(Parameters[5]);
        return ServerInterface.ConnectToServer("UpdateDiaryEntry", Parameters);
    }
    
    @GET
    @Path("GetDiaryEntry/{UserID}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String GetDiaryEntry(@PathParam("UserID") String UserID)
    {
        String[] Parameters = new String[1];
        Parameters[0] = UserID;
        Parameters[0] = ServerInterface.SanitiseURL(Parameters[0]);
        return ServerInterface.ConnectToServer("GetDiaryEntry", Parameters);
    }
    
    @GET
    @Path("CheckDiaryDate/{UserID}")
    @Produces({MediaType.TEXT_PLAIN})
    public String CheckDiaryDate(@PathParam("UserID") String UserID)
    {
        String[] Parameters = new String[1];
        Parameters[0] = UserID;
        Parameters[0] = ServerInterface.SanitiseURL(Parameters[0]);    
        return ServerInterface.ConnectToServer("CheckDiaryDate", Parameters);
    }
}

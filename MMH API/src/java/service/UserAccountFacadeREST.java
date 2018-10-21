/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import MMHPackage.UserAccount;
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

@Stateless
@Path("mmhpackage.useraccount")
public class UserAccountFacadeREST extends AbstractFacade<UserAccount>
{
    RunServerInterface ServerInterface = new RunServerInterface();
    @PersistenceContext(unitName = "MMH_APIPU")
    private EntityManager em;

    public UserAccountFacadeREST()
    {
        super(UserAccount.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(UserAccount entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, UserAccount entity) {
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
    public UserAccount find(@PathParam("id") Integer id)
    {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<UserAccount> findAll()
    {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<UserAccount> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to)
    {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST()
    {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }
    
    //Paths our API uses.
    @GET
    @Path("GetMusicHistory/{UserID}/{UserPassword}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String GetMusicHistory(@PathParam("UserID") String UserID,
            @PathParam("UserPassword") String UserPassword)
    {
        String[] Parameters = new String[2];
        Parameters[0] = UserID;
        Parameters[1] = UserPassword;
        ServerInterface.RemoveDashFromString(Parameters[0]);
        ServerInterface.RemoveDashFromString(Parameters[1]);
        
        return ServerInterface.ConnectToServer("GetMusicHistory", Parameters);
    }
    
    @GET
    @Path("GetUserDetailsRegistration/{UserID}/{UserPassword}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String GetUserDetailsRegistration(@PathParam("UserID") String UserID,
            @PathParam("UserPassword") String UserPassword)
    {
        String[] Parameters = new String[2];
        Parameters[0] = UserID;
        Parameters[1] = UserPassword;
        ServerInterface.RemoveDashFromString(Parameters[0]);
        ServerInterface.RemoveDashFromString(Parameters[1]);
        
        return ServerInterface.ConnectToServer("GetUserDetailsRegistration",
                Parameters);
    }
    
    @GET
    @Path("GetUserDetails/{UserID}/{UserPassword}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String GetUserDetails(@PathParam("UserID") String UserID,
            @PathParam("UserPassword") String UserPassword)
    {
        String[] Parameters = new String[2];
        Parameters[0] = UserID;
        Parameters[1] = UserPassword;
        ServerInterface.RemoveDashFromString(Parameters[0]);
        ServerInterface.RemoveDashFromString(Parameters[1]);
        
        return ServerInterface.ConnectToServer("GetUserDetails", Parameters);
    }
    
    @GET
    @Path("GetUserID/{EmailAddress}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String GetUserID(@PathParam("EmailAddress") String EmailAddress)
    {
        String[] Parameters = new String[1];
        Parameters[0] = EmailAddress;
        
        return ServerInterface.ConnectToServer("GetUserID", Parameters);
    }
    
    @GET
    @Path("GetUserPassword/{UserID}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String GetUserPassword(@PathParam("UserID") String UserID)
    {
        String[] Parameters = new String[1];
        Parameters[0] = UserID;
        
        return ServerInterface.ConnectToServer("GetUserPassword", Parameters);
    }   
    
    @GET
    @Path("GetUserSettings/{UserID}/{UserPassword}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String GetUserSettings(@PathParam("UserID") String UserID,
            @PathParam("UserPassword") String UserPassword)
    {
        String[] Parameters = new String[2];
        Parameters[0] = UserID;
        Parameters[1] = UserPassword;
        ServerInterface.RemoveDashFromString(Parameters[0]);
        ServerInterface.RemoveDashFromString(Parameters[1]);
        
        return ServerInterface.ConnectToServer("GetUserSettings", Parameters);
    }
    
    @GET
    @Path("InsertNewUser/{FirstName}/{LastName}/{EmailAddress}/"
            + "{DateOfBirth}/{Gender}/{UserPassword}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String InsertNewUser(@PathParam("UserID") String UserID,
            @PathParam("FirstName") String FirstName,
            @PathParam("LastName") String LastName,
            @PathParam("EmailAddress") String EmailAddress,
            @PathParam("DateOfBirth") String DateOfBirth,
            @PathParam("Gender") String Gender,
            @PathParam("UserPassword") String UserPassword)
    {
        String[] Parameters = new String[6];
        Parameters[0] = FirstName;
        Parameters[1] = LastName;
        Parameters[2] = EmailAddress;
        Parameters[3] = DateOfBirth;
        Parameters[4] = Gender;
        Parameters[5] = UserPassword;
        
        ServerInterface.RemoveDashFromString(Parameters[0]);
        ServerInterface.RemoveDashFromString(Parameters[1]);
        ServerInterface.RemoveDashFromString(Parameters[2]);
        ServerInterface.RemoveDashFromString(Parameters[3]);
        ServerInterface.RemoveDashFromString(Parameters[4]);
        ServerInterface.RemoveDashFromString(Parameters[5]);
        
        return ServerInterface.ConnectToServer("InsertNewUser", Parameters);
    }
    
    @GET
    @Path("IsEmailAddressUnique/{EmailAddress}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String IsEmailAddressUnique(@PathParam("EmailAddress") String EmailAddress)
    {
        String[] Parameters = new String[1];
        Parameters[0] = EmailAddress;
        
        return ServerInterface.ConnectToServer("IsEmailAddressUnique", Parameters);
    }
    
    @GET
    @Path("VerifyLogin/{EmailAddress}/{UserPassword}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String VerifyLogin(@PathParam("EmailAddress") String EmailAddress,
            @PathParam("UserPassword") String Password)
    {
        String[] Parameters = new String[2];
        Parameters[0] = EmailAddress;
        Parameters[1] = Password;
        
        ServerInterface.RemoveDashFromString(Parameters[0]);
        ServerInterface.RemoveDashFromString(Parameters[1]);
        
        return ServerInterface.ConnectToServer("VerifyLogin", Parameters);
    }
    
    @GET
    @Path("UpdatePassword/{UserID}/{UserPassword}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String UpdatePassword(@PathParam("UserID") String UserID,
            @PathParam("UserPassword") String UserPassword)
    {
        String[] Parameters = new String[2];
        Parameters[0] = UserID;
        Parameters[1] = UserPassword;
        
        ServerInterface.RemoveDashFromString(Parameters[0]);
        ServerInterface.RemoveDashFromString(Parameters[1]);
        
        return ServerInterface.ConnectToServer("UpdatePassword", Parameters);
    }
    
    @GET
    @Path("UpdateSettings/{MakeRecommendations}/{MoodFrequency}/"
            + "{UserID}/{UserPassword}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String UpdateSettings(@PathParam("MakeRecommendations")
            String MakeRecommendations,
            @PathParam("MoodFrequency") String MoodFrequency,
            @PathParam("UserID") String UserID,
            @PathParam("UserPassword") String UserPassword)
    {
        String[] Parameters = new String[4];
        Parameters[0] = MakeRecommendations;
        Parameters[1] = MoodFrequency;
        Parameters[2] = UserID;
        Parameters[3] = UserPassword;
        
        ServerInterface.RemoveDashFromString(Parameters[0]);
        ServerInterface.RemoveDashFromString(Parameters[1]);
        ServerInterface.RemoveDashFromString(Parameters[2]);
        ServerInterface.RemoveDashFromString(Parameters[3]);
        
        return ServerInterface.ConnectToServer("UpdateSettings", Parameters);
    }
    
    @GET
    @Path("UpdateNewUser/{FirstName}/{LastName}/{EmailAddress}/"
            + "{DateOfBirth}/{Gender}/{UserID}/{UserPassword}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String UpdateNewUser(@PathParam("FirstName") String FirstName,
            @PathParam("LastName") String LastName,
            @PathParam("EmailAddress") String EmailAddress,
            @PathParam("DateOfBirth") String DateOfBirth,
            @PathParam("Gender") String Gender,
            @PathParam("UserID") String UserID,
            @PathParam("UserPassword") String UserPassword)
    {
        String[] Parameters = new String[7];
        
        Parameters[0] = FirstName;
        Parameters[1] = LastName;
        Parameters[2] = EmailAddress;
        Parameters[3] = DateOfBirth;
        Parameters[4] = Gender;
        Parameters[5] = UserID;
        Parameters[6] = UserPassword;
        
        ServerInterface.RemoveDashFromString(Parameters[0]);
        ServerInterface.RemoveDashFromString(Parameters[1]);
        ServerInterface.RemoveDashFromString(Parameters[2]);
        ServerInterface.RemoveDashFromString(Parameters[3]);
        ServerInterface.RemoveDashFromString(Parameters[4]);
        ServerInterface.RemoveDashFromString(Parameters[5]);
        ServerInterface.RemoveDashFromString(Parameters[6]);
        
        return ServerInterface.ConnectToServer("UpdateNewUser", Parameters);
    }
    
    @GET
    @Path("UpdateUser/{FirstName}/{LastName}/{EmailAddress}/"
            + "{DateOfBirth}/{Gender}/{UserID}/{UserPassword}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String UpdateUser(@PathParam("FirstName") String FirstName,
            @PathParam("LastName") String LastName,
            @PathParam("EmailAddress") String EmailAddress,
            @PathParam("DateOfBirth") String DateOfBirth,
            @PathParam("Gender") String Gender,
            @PathParam("UserID") String UserID,
            @PathParam("UserPassword") String UserPassword)
    {
        String[] Parameters = new String[7];   
        Parameters[0] = FirstName;
        Parameters[1] = LastName;
        Parameters[2] = EmailAddress;
        Parameters[3] = DateOfBirth;
        Parameters[4] = Gender;
        Parameters[5] = UserID;
        Parameters[6] = UserPassword;
        
        ServerInterface.RemoveDashFromString(Parameters[0]);
        ServerInterface.RemoveDashFromString(Parameters[1]);
        ServerInterface.RemoveDashFromString(Parameters[2]);
        ServerInterface.RemoveDashFromString(Parameters[3]);
        ServerInterface.RemoveDashFromString(Parameters[4]);
        ServerInterface.RemoveDashFromString(Parameters[5]);
        ServerInterface.RemoveDashFromString(Parameters[6]);
        
        return ServerInterface.ConnectToServer("UpdateUser", Parameters);
    }
    
    @GET
    @Path("UpdateUserSecondPage/{MusicQuestionOne}/{MusicQuestionTwo}/"
            + "{MusicQuestionThree}/{MusicQuestionFour}/{UserID}/{UserPassword}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String UpdateUserSecondPage(@PathParam("MusicQuestionOne")
            String MusicQuestionOne,
            @PathParam("MusicQuestionTwo") String MusicQuestionTwo,
            @PathParam("MusicQuestionThree") String MusicQuestionThree,
            @PathParam("MusicQuestionFour") String MusicQuestionFour,
            @PathParam("UserID") String UserID,
            @PathParam("UserPassword") String UserPassword)
    {
        String[] Parameters = new String[6];      
        Parameters[0] = MusicQuestionOne;
        Parameters[1] = MusicQuestionTwo;
        Parameters[2] = MusicQuestionThree;
        Parameters[3] = MusicQuestionFour;
        Parameters[4] = UserID;
        Parameters[5] = UserPassword;
        
        ServerInterface.RemoveDashFromString(Parameters[0]);
        ServerInterface.RemoveDashFromString(Parameters[1]);
        ServerInterface.RemoveDashFromString(Parameters[2]);
        ServerInterface.RemoveDashFromString(Parameters[3]);
        ServerInterface.RemoveDashFromString(Parameters[4]);
        ServerInterface.RemoveDashFromString(Parameters[5]);
        
        return ServerInterface.ConnectToServer("UpdateUserSecondPage", Parameters);
    }
    
    @GET
    @Path("VerifyPassword/{UserID}/{UserPassword}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String VerifyPassword(@PathParam("UserID") String UserID,
            @PathParam("UserPassword") String Password)
    {
        String[] Parameters = new String[2];
        Parameters[0] = UserID;
        Parameters[1] = Password;
        
        ServerInterface.RemoveDashFromString(Parameters[0]);
        ServerInterface.RemoveDashFromString(Parameters[1]);
        
        return ServerInterface.ConnectToServer("VerifyPassword", Parameters);
    }
}
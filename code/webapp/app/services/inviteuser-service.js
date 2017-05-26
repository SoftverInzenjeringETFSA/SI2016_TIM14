import Ember from 'ember';
import BaseService from './base-service';
import User from '../models/user';
import Invite from '../models/invite';

export default BaseService.extend({

    inviteUser: function(usernameOfInvitee, usernameOfInviter, idOfInviter) {
        var params = [usernameOfInvitee, usernameOfInviter, idOfInviter];
        this.ajax({ url: `korisnici/inviteUser`, type: "POST", data: {usernameOfInvitee: usernameOfInvitee, usernameOfInviter: usernameOfInviter, idOfInviter: idOfInviter},}).then(function(data) {
        });
    
        return true;
    },
   
    findInvites: function(id){
        var invites = [];
        this.ajax({ url: `korisnici/findInvites?id=${id}`, type: "GET"}).then(function(data) {
            data.forEach(function(invite) {
                
                invites.addObject(Invite.create(invite));
            });
        });
        return invites;
    },

});

import Ember from 'ember';
import BaseService from './base-service';
import User from '../models/user';

export default BaseService.extend({

    inviteUser: function(usernameOfInvitee, usernameOfInviter, idOfInviter) {
        var params = [usernameOfInvitee, usernameOfInviter, idOfInviter];
        this.ajax({ url: `korisnici/inviteUser`, type: "POST", data: {usernameOfInvitee: usernameOfInvitee, usernameOfInviter: usernameOfInviter, idOfInviter: idOfInviter},}).then(function(data) {
        });
    
        return true;
    },

});

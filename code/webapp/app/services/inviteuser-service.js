import Ember from 'ember';
import BaseService from './base-service';
import User from '../models/user';

export default BaseService.extend({

    inviteUser: function(email) {
        var korisnici = [];
        this.ajax({ url: `korisnici/inviteUser`, type: "POST", data: email}).then(function(data) {
        });
    
        return true;
    },

});

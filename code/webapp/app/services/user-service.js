import Ember from 'ember';
import BaseService from './base-service';
import user from '../models/user';

export default BaseService.extend({
	all: function() {
        var korisnici = [];
        this.ajax({ url: `korisnici/all`, type: "GET"}).then(function(data) {
            data.forEach(function(korisnik) {
                korisnici.addObject(user.create(korisnik));
            });
        });

        console.log(korisnici);
        return korisnici;
    },

    store: function(korisnik) {
        var korisnici = [];
        this.ajax({ url: `korisnici/store`, type: "POST", data: JSON.stringify(korisnik)}).then(function(data) {
        });
    
        return true;
    },

});

import Ember from 'ember';
import BaseService from './base-service';
import User from '../models/user';

export default BaseService.extend({
	all: function() {
        var users = [];
        this.ajax({ url: `korisnici/all`, type: "GET"}).then(function(data) {
            data.forEach(function(user) {
                users.addObject(User.create(user));
            });

        });
        return users;

    },

    store: function(korisnik) {
        var korisnici = [];
        this.ajax({ url: `korisnici/store`, type: "POST", data: JSON.stringify(korisnik)}).then(function(data) {
        });

        return true;
    },

	changePassword: function(password, username){
		this.ajax({ url: `korisnici/promijenipassword`, type: "POST", data: {username:username, password:password}}).then(function(data) {
		});
		return true;
	},

    searchUsers: function(searchTerm){
        var users = [];
        this.ajax({ url: `korisnici/searchUsers?searchTerm=${searchTerm}`, type: "GET"}).then(function(data) {
            data.forEach(function(user) {
                users.addObject(User.create(user));
            });
        });
        return users;
    }


});

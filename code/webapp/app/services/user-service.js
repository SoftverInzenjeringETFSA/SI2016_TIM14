import Ember from 'ember';
import BaseService from './base-service';
import User from '../models/user';

export default BaseService.extend({
	all: function() {
        var korisnici = [];
        this.ajax({ url: `korisnici/all`, type: "GET"}).then(function(data) {
        	console.log(data);
        	console.log('For reals')
            data.forEach(function(korisnik) {
            	console.log('Hello nitherfucker')
                console.log(korisnik);
                 	const user = User.createRecord({
					//      id: 1,
        			username: korisnik.username,
        			email: korisnik.email
			    });
                //const foo = User.create({ username: korisnik.username, email: korisnik.email });
                //korisnici.addObject(User.create(korisnik));
                //korisnici.pushObject(foo);

            });
             console.log(korisnici);
        return korisnici;
        });


    },

    store: function(korisnik) {
        var korisnici = [];
        this.ajax({ url: `korisnici/store`, type: "POST", data: JSON.stringify(korisnik)}).then(function(data) {
        });

        return true;
    },

    searchUserPerEmail: function(email) {
    				console.log(email);
    				var returnData;
        return this.ajax({ url: `korisnici/searchUserPerEmail`, type: "POST", data: email})
    },

		changePassword: function(password, username){
			console.log(password, username);
			this.ajax({ url: `korisnici/promijenipassword`, type: "POST", data: {username:username, password:password}}).then(function(data) {
			});

			return true;
		}

});

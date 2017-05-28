import Ember from 'ember';
import BaseService from './base-service';
import User from '../models/user';

export default BaseService.extend({
    session: Ember.inject.service(),
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
    },

    editKorisnik: function(editKorisnika,username) {
         var ime = editKorisnika.firstName;
         var prezime = editKorisnika.lastName;
         var zanimanje = editKorisnika.zanimanje;
         var grad = editKorisnika.location;
         var email = editKorisnika.email;
         var interesovanje = editKorisnika.interesovanja;
         var omeni = editKorisnika.omeni;
    
         this.ajax({ url: `korisnici/editkorisnik`, type: "POST", data: {ime:ime, prezime:prezime, zanimanje:zanimanje, grad:grad,email:email,
            interesovanje:interesovanje, omeni:omeni, username:username} }).then(function(data) {


         let korisnik = this.getProperties('username','password');
         korisnik.username = this.get('session.data.authenticated.korisnik.username');
         korisnik.password = this.get('session.data.authenticated.korisnik.password');
         
                this.get('session').authenticate('authenticator:application', korisnik, (data) => {
                    console.log(data);
                })
                .catch(reason => {
                    //Ember.set(this, 'errorMessage', JSON.parse(reason.responseText).errorMessage);
                    this.set('authenticationError', this.errorMessage || reason);
                });

        });
        return true;
    },

    deleteUser: function(iduser)
    {
   
           this.ajax({ url: `korisnici/obrisikorisnika`, type: "POST", data: {iduser:iduser}}).then(function(data) {
        });
        return true;


    }


});

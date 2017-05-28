import Ember from 'ember';
import BaseService from './base-service';
import Group from '../models/group';

export default BaseService.extend({
  all: function() {
      var grupe = [];
      this.ajax({ url: `grupe/all`, type: "GET"}).then(function(data) {
          data.forEach(function(group) {
              users.addObject(User.create(group));
          });

      });
      return grupe;

  },
  createGroup: function(grupa) {
      var grupe = [];
      var ime = grupa.name;
      var opis = grupa.description;
      this.ajax({ url: `grupe/kreirajgrupu`, type: "POST", data: {ime:ime, opis:opis}}).then(function(data) {
      });

      return true;
  },

  deleteGroup: function(idgrupa){

    this.ajax({ url: `grupe/obrisigrupu`, type: "POST", data: {idgrupa:idgrupa}}).then(function(data) {
        });
        return true;
  },

  myGroups: function(idUser) {
      var grupe = [];
      this.ajax({ url: `grupe/myGroups?idUser=${idUser}`, type: "GET"}).then(function(data) {
          data.forEach(function(group) {
              grupe.addObject(Group.create(group));
          });

      });
      return grupe;

  },

  searchGroups: function(searchTerm){
      var groups = [];
      this.ajax({ url: `grupe/searchGroups?searchTerm=${searchTerm}`, type: "GET"}).then(function(data) {
          data.forEach(function(group) {
            console.log(group);
              groups.addObject(Group.create(group));
          });
      });
      return groups;
  },

   joinGroup: function(idOfGroup, idOfUser) {
        this.ajax({ url: `grupe/joinGroup`, type: "POST", data: {idOfGroup: idOfGroup, idOfUser: idOfUser},}).then(function(data) {
        });
    
        return true;
    },

     leaveGroup: function(idOfGroup, idOfUser) {
        this.ajax({ url: `grupe/leaveGroup`, type: "POST", data: {idOfGroup: idOfGroup, idOfUser: idOfUser},}).then(function(data) {
        });
    
        return true;
    },
});

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
  }
});

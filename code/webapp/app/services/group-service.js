import Ember from 'ember';
import BaseService from './base-service';
import Group from '../models/group';

export default BaseService.extend({
  createGroup: function(grupa) {
      var grupe = [];
      var ime = grupa.name;
      var opis = grupa.description;
      this.ajax({ url: `grupe/kreirajgrupu`, type: "POST", data: {ime:ime, opis:opis}}).then(function(data) {
      });

      return true;
  }
});

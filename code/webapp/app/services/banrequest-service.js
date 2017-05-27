import Ember from 'ember';
import BaseService from './base-service';
import Ban from '../models/ban';

export default BaseService.extend({
    session: Ember.inject.service(),
	all: function() {
        var banovi = [];
        this.ajax({ url: `banzahtjevi/all`, type: "GET"}).then(function(data) {
            data.forEach(function(ban) {
                banovi.addObject(Ban.create(ban));
            });

        });
        return banovi;
    }

});
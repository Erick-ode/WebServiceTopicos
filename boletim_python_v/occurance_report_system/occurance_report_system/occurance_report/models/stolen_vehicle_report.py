from .part import Part
from .address import Address
from .vehicle import Vehicle

class StolenVehicleReport:
    def __init__(self):
        self.id = None
        self.occurrence_date = None
        self.occurrence_day_time = None
        self.part = None
        self.occurrence_local = None
        self.stolen_vehicle = None

    def get_id(self):
        return self.id

    def set_id(self, id):
        self.id = id

    def get_occurrence_date(self):
        return self.occurrence_date

    def set_occurrence_date(self, occurrence_date):
        self.occurrence_date = occurrence_date

    def get_occurrence_day_time(self):
        return self.occurrence_day_time

    def set_occurrence_day_time(self, occurrence_day_time):
        self.occurrence_day_time = occurrence_day_time

    def get_part(self):
        return self.part

    def set_part(self, part):
        self.part = part

    def get_occurrence_local(self):
        return self.occurrence_local

    def set_occurrence_local(self, occurrence_local):
        self.occurrence_local = occurrence_local

    def get_stolen_vehicle(self):
        return self.stolen_vehicle

    def set_stolen_vehicle(self, stolen_vehicle):
        self.stolen_vehicle = stolen_vehicle

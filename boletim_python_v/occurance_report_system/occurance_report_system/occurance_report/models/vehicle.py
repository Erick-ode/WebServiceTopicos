from .registration import Registration


class Vehicle:
    def __init__(self):
        self.year = None
        self.color = None
        self.brand = None
        self.type = None
        self.registration = None

    def get_year(self):
        return self.year

    def get_color(self):
        return self.color

    def get_brand(self):
        return self.brand

    def get_type(self):
        return self.type

    def get_registration(self):
        return self.registration

    def set_year(self, year):
        self.year = year

    def set_color(self, color):
        self.color = color

    def set_brand(self, brand):
        self.brand = brand

    def set_type(self, type):
        self.type = type

    def set_registration(self, registration):
        self.registration = registration

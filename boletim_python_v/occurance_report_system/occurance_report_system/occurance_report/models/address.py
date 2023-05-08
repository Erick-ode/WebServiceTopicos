class Address:
    def __init__(self):
        self.street_name = None
        self.number = None
        self.district = None
        self.city = None
        self.state = None

    def get_street_name(self):
        return self.street_name

    def set_street_name(self, streetName):
        self.street_name = streetName

    def get_number(self):
        return self.number

    def set_number(self, number):
        self.number = number

    def get_district(self):
        return self.district

    def set_district(self, district):
        self.district = district

    def get_city(self):
        return self.city

    def set_city(self, city):
        self.city = city

    def get_state(self):
        return self.state

    def set_state(self, state):
        self.state = state

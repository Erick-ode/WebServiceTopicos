class Registration:
    def __init__(self):
        self.plate = None
        self.state = None
        self.city = None

    def get_plate(self):
        return self.plate

    def set_plate(self, plate):
        self.plate = plate

    def get_state(self):
        return self.state

    def set_state(self, state):
        self.state = state

    def get_city(self):
        return self.city

    def set_city(self, city):
        self.city = city

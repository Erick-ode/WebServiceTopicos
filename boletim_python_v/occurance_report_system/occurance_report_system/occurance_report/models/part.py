class Part:
    def __init__(self):
        self.name = None
        self.email = None
        self.phone = None
        self.type_involvement = None

    def get_name(self):
        return self.name

    def set_name(self, name):
        self.name = name

    def get_email(self):
        return self.email

    def set_email(self, email):
        self.email = email

    def get_phone(self):
        return self.phone

    def set_phone(self, phone):
        self.phone = phone

    def get_type_involvement(self):
        return self.type_involvement

    def set_type_involvement(self, type_involvement):
        self.type_involvement = type_involvement

from datetime import datetime
from ..dao import InMemoryReportDao
from ..models import stolen_vehicle_report


class ReportManager:

    def __init__(self):
        self.report_dao = None

    def init(self):
        self.report_dao = in_memory_report_dao

    def register(self, report):
        if self.is_data_valid(report.occurrence_date):
            self.report_dao.register(report)
        else:
            raise ValueError("A data informada é maior que a data atual!")

    def read_all(self):
        return self.report_dao.read_all()

    def read_by_id(self, id):
        return self.report_dao.read_by_id(id)

    def read_by_city(self, city):
        return self.report_dao.read_by_city(city)

    def read_by_day_time(self, day_time):
        return self.report_dao.read_by_day_time(day_time)

    def remove(self, id):
        self.report_dao.remove(id)

    def is_data_valid(self, report_date):
        current_date = datetime.now().date()
        return report_date.date() <= current_date

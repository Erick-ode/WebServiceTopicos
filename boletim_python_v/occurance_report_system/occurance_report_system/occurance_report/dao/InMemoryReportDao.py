from typing import List
from .ReportDao import ReportDAO
from ..models import stolen_vehicle_report


class InMemoryReportDAO(ReportDAO):
    def __init__(self):
        self.incident_reports = []

    def register(self, stolen_vehicle_report: stolen_vehicle_report) -> None:
        self.incident_reports.append(stolen_vehicle_report)

    def read_by_id(self, id: int) -> stolen_vehicle_report:
        for report in self.incident_reports:
            if report.get_id() == id:
                return report
        return None

    def read_by_city(self, city: str) -> List[stolen_vehicle_report]:
        list_reports = []
        for report in self.incident_reports:
            if report.get_occurrence_local().get_city() == city:
                list_reports.append(report)
        return list_reports

    def read_by_day_time(self, day_time: str) -> List[stolen_vehicle_report]:
        list_reports = []
        for report in self.incident_reports:
            if report.get_occurrence_day_time() == day_time:
                list_reports.append(report)
        return list_reports

    def remove(self, id: int) -> None:
        report = self.read_by_id(id)
        if report:
            self.incident_reports.remove(report)

    def read_all(self) -> List[stolen_vehicle_report]:
        return self.incident_reports

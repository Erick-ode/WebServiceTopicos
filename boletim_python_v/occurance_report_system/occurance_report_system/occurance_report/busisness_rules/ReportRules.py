from abc import ABC, abstractmethod
from typing import List
from ..models import stolen_vehicle_report

class ReportRules(ABC):
    @abstractmethod
    def register(self, report: stolen_vehicle_report) -> None:
        pass

    @abstractmethod
    def read_all(self) -> List[stolen_vehicle_report]:
        pass

    @abstractmethod
    def read_by_id(self, id: int) -> stolen_vehicle_report:
        pass

    @abstractmethod
    def read_by_city(self, city: str) -> List[stolen_vehicle_report]:
        pass

    @abstractmethod
    def read_by_day_time(self, day_time: str) -> List[stolen_vehicle_report]:
        pass

    @abstractmethod
    def remove(self, id: int) -> None:
        pass

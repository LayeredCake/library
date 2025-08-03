import csv
import json
import requests
from enum import Enum 

class GenreType(Enum):
    FANTASY = 1
    SCIENCEFICTION = 2
    LITERATURE = 3
    NONFICTION = 4
    OTHER = 5
    
class FormatType(Enum):
    PAPERBACK = 1
    HARDCOVER = 2
    
class ConditionType(Enum):
    NEW = 1
    GOOD = 2
    BAD = 3
    UNKNOWN = 4
    
def stringToEnumKey(inStr):
    inStr = "".join(inStr.split())
    return inStr.upper()
    
class BookData:
    
    def __init__(self, values):
        self.values = values
        
    def removeEmptyFields(self, fields):
        for fieldName in fields:
            try:
                value = self.values[fieldName]
            except KeyError:
                return
            if value == '':
                del self.values[fieldName]
            
    def translateEnumValue(self, fieldName, enum):
        try:
            fieldValue = self.values[fieldName]
        except KeyError:
            return
        try:
            self.values[fieldName] = enum[stringToEnumKey(fieldValue)].value
        except KeyError:
            print(stringToEnumKey(fieldValue))


def processBookData(bookData):
    bookData.removeEmptyFields(["PageCount", "Genre", "Condition", "Format"])
    bookData.translateEnumValue("Genre", GenreType)
    bookData.translateEnumValue("Condition", ConditionType)
    bookData.translateEnumValue("Format", FormatType)
    return bookData.values

def parseRow(row):
    bookData = BookData(row)
    return processBookData(bookData)
    
def main():
    with open("input.csv", "r") as file:
        csvReader = csv.DictReader(file)
        data = [parseRow(row) for row in csvReader]
        for row in data:
            jsonObj = json.dumps(row)
            print(jsonObj)
            #result = requests.post("http://192.168.2.228:5022/api/Books", data=jsonObj, headers={"accept": "text/plain", "Content-Type": "application/json"})
            result = requests.post("http://localhost:5022/api/Books", data=jsonObj, headers={"accept": "text/plain", "Content-Type": "application/json"})
            print(result.status_code)
            
main()
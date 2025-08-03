import csv
import json
import requests

def removeEmptyFields(inputDict):
    outputDict = {}
    for elem in inputDict:
        if inputDict[elem] != '':
            outputDict[elem] = inputDict[elem]
    return outputDict
    
def removeEmptyPageCount(inputDict):
    outputDict = {}
    for elem in inputDict:
        if inputDict[elem] != '' or elem != 'PageCount':
            outputDict[elem] = inputDict[elem]
    return outputDict

def main():
    with open("input.csv", "r") as file:
        csvReader = csv.DictReader(file)
        data = [removeEmptyPageCount(row) for row in csvReader]
        for row in data:
            jsonObj = json.dumps(row)
            print(jsonObj)
            result = requests.post("http://192.168.2.228:5022/api/Books", data=jsonObj, headers={"accept": "text/plain", "Content-Type": "application/json"})
            print(result.status_code)
            
main()
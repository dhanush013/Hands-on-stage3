"use strict";
exports.__esModule = true;
var EmployeeTest = /** @class */ (function () {
    function EmployeeTest(_id, _name, _salary, _permanent, _departmentId, _departmentName) {
        this.Skills = [
            { SkillId: 1, SkillName: 'HTML' },
            { SkillId: 2, SkillName: 'CSS' },
            { SkillId: 3, SkillName: 'JavaScript' }
        ];
        this.Id = _id;
        this.Name = _name;
        this.Salary = _salary;
        this.Permanent = _permanent;
        this.DepartmentId = _departmentId;
        this.DepartmentName = _departmentName;
    }
    EmployeeTest.prototype.Display = function () {
        console.log('Id: ' + this.Id);
        console.log('\nName: ' + this.Name);
        console.log('\nSalary: ' + this.Salary);
        console.log('\nPermanent: ' + this.Permanent);
        console.log('\nDepartment Id: ' + this.DepartmentId);
        console.log('\nDepartment Name: ' + this.DepartmentName);
        for (var i = 0; i < this.Skills.length; i++) {
            console.log("\nSkills[" + i + "]:" + this.Skills[i].SkillId + "," + this.Skills[i].SkillName);
        }
    };
    return EmployeeTest;
}());
var details = new EmployeeTest('EM003', 'John', 10000, true, 1, 'Payroll');
details.Display();

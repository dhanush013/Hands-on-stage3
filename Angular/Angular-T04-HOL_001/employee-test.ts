import {Employee} from './Employee';
import {department} from './department';
import {skill} from './skill';

class EmployeeTest implements Employee,department,skill
{
    SkillId: number;
    SkillName: string;
    DepartmentId: number;
    DepartmentName: string;
    Id: string;
    Name: string;
    Salary: number;
    Permanent: boolean;
    Skills:skill[]=
      [
          {SkillId:1,SkillName:'HTML'},
          {SkillId:2,SkillName:'CSS'},
          {SkillId:3,SkillName:'JavaScript'}
      ]  
    
    constructor(_id:string,_name:string,_salary:number,_permanent:boolean,_departmentId:number,
        _departmentName:string) 
    {
      this.Id=_id;
      this.Name=_name;
      this.Salary=_salary;
      this.Permanent=_permanent;
      this.DepartmentId=_departmentId;
      this.DepartmentName=_departmentName;  
        
    }
    Display():void{
        console.log('Id: '+this.Id);
        console.log('\nName: '+this.Name);
        console.log('\nSalary: '+this.Salary);
        console.log('\nPermanent: '+this.Permanent);
        console.log('\nDepartment Id: '+this.DepartmentId);
        console.log('\nDepartment Name: '+this.DepartmentName);
        for (var i=0;i<this.Skills.length;i++)
        {
            console.log("\nSkills["+i+"]:"+this.Skills[i].SkillId+","+this.Skills[i].SkillName);
        }
        
    }  
}

var details=new EmployeeTest('EM003','John',10000,true,1,'Payroll');
details.Display();
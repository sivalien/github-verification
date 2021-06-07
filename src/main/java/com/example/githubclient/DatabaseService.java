package com.example.githubclient;

import com.example.githubclient.model.databasemodels.RepoInfo;
import com.example.githubclient.model.databasemodels.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DatabaseService {
    @Autowired
    private JdbcTemplate jdbc;

    List<Student> getStudents() {
        return jdbc.query("SELECT * FROM Student", (x, y) -> new Student(x.getInt("student_id"), x.getString("first_name"), x.getString("last_name"), x.getString("login")));
    }

    List<RepoInfo> getRepoInfo() {
        return jdbc.query("SELECT login, name, is_checked FROM Student INNER JOIN Repo ON Student.student_id = Repo.student_id", (x, y) -> new RepoInfo(x.getString("login"), x.getString("name"), x.getBoolean("is_checked")));
    }
}

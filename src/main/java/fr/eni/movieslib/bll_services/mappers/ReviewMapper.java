package fr.eni.movieslib.bll_services.mappers;

import fr.eni.movieslib.bo.movies.Review;

import fr.eni.movieslib.dal.UserDAO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ReviewMapper implements RowMapper<Review> {

    UserDAO userDAO;

    public ReviewMapper(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
        Review review = new Review();
        review.setId(rs.getLong("id"));
        review.setRating(rs.getInt("rating"));
        review.setComment(rs.getString("comment"));
        review.setMember(userDAO.findById(rs.getLong("user_id")));
        return review;
    }

}

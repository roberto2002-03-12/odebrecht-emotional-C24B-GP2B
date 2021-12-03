package odebrecht.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import odebrecht.app.model.Meeting;
import odebrecht.app.repository.MeetingRepository;

@Service("meeting")
public class MeetingServiceImpl {
	
	@Autowired
	private MeetingRepository meetingRepository;
	
	public Meeting select(Long id) {
		return meetingRepository.findById(id);
	}
	
	public void save(Meeting meeting) {
		meetingRepository.save(meeting);
	}
	
	public List<Meeting> listMeeting(Long id) {
		return meetingRepository.listByUser(id);
	}
	
}
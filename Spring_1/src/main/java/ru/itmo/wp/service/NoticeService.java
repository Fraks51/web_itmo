package ru.itmo.wp.service;

import org.springframework.stereotype.Service;
import ru.itmo.wp.domain.Notice;
import ru.itmo.wp.form.NoticeForm;
import ru.itmo.wp.repository.NoticeRepository;

import java.util.List;

@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public List<Notice> findAll() {return noticeRepository.findAllByOrderById();}

    public Notice create(NoticeForm form) {
        Notice notice = new Notice();
        notice.setContent(form.getContent());
        noticeRepository.save(notice);
        return notice;
    }

}

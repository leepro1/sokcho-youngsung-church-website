package com.sokchoys.domain.notice.service;

import com.sokchoys.domain.notice.entity.Notice;
import com.sokchoys.domain.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public List<Notice> findAllNotices() {
        return noticeRepository.findAll();
    }

    public Optional<Notice> findNoticeById(Long id) {
        return noticeRepository.findById(id);
    }

    public Notice createNotice(String title, String content, String author) {
        Notice notice = Notice.builder()
            .title(title)
            .content(content)
            .author(author)
            .build();
        return noticeRepository.save(notice);
    }

    public Notice updateNotice(Long id, String title, String content) {
        Notice notice = noticeRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("공지사항이 없습니다."));
        notice.update(title, content);
        return noticeRepository.save(notice);
    }

    public void deleteNotice(Long id) {
        noticeRepository.deleteById(id);
    }
}

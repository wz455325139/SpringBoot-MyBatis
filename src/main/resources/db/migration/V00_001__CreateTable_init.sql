CREATE TABLE user (
  `user_id` char(10) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  `wechar_id` varchar(20) NOT NULL,
  `city` varchar(40) NOT NULL,
  `head_image_url` varchar(256) NOT NULL,
  `role` char(1) NOT NULL,
  `vouchers` int(11) NOT NULL,
  `diamonds` int(11) NOT NULL,
  `gold` int(11) NOT NULL,
  `sliver` int(11) NOT NULL,
  `copper` int(11) NOT NULL,
  `applause` int(11) NOT NULL,
  `delete_flg` char(1) NOT NULL,
  `create_user` varchar(10) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(10) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE user_group (
  `user_group_id` char(10) NOT NULL,
  `user_group_name` varchar(20) NOT NULL,
  `image_url` varchar(20) NOT NULL,
  `vouchers` int(11) NOT NULL,
  `delete_flg` char(1) NOT NULL,
  `create_user` varchar(10) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(10) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`user_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE event (
  `event_id` int(11) NOT NULL AUTO_INCREMENT,
  `event_titile` varchar(45) NOT NULL,
  `event_details` varchar(20) NOT NULL,
  `event_images_url` varchar(256) NOT NULL,
  `event_user_group` char(10) NOT NULL,
  `diamonds` int(11) NOT NULL,
  `gold` int(11) NOT NULL,
  `sliver` int(11) NOT NULL,
  `copper` int(11) NOT NULL,
  `applause` int(11) NOT NULL,
  `delete_flg` char(1) NOT NULL,
  `create_user` varchar(10) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(10) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`event_id`),
  KEY `event_user_group_idx` (`event_user_group`),
  CONSTRAINT `event_user_group` FOREIGN KEY (`event_user_group`) REFERENCES `user_group` (`user_group_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE commets (
  `commet_id` char(10) NOT NULL,
  `event_id` char(10) NOT NULL,
  `comment` varchar(45) NOT NULL,
  `comment_owner` char(10) NOT NULL,
  `comment_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_flg` char(1) NOT NULL,
  `create_user` varchar(10) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(10) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`commet_id`),
  KEY `comment_owner_idx` (`comment_owner`),
  CONSTRAINT `comment_owner` FOREIGN KEY (`comment_owner`) REFERENCES `event` (`event_user_group`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE thumbup (
  `event_id` int(11) NOT NULL,
  `thumbup_user` char(10) NOT NULL,
  `thumbup_type` char(1) NOT NULL,
  `thumbup_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(10) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_user` varchar(10) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  KEY `event_id_idx` (`event_id`),
  KEY `thumbup_user_idx` (`thumbup_user`),
  CONSTRAINT `event_id_2` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `thumbup_user` FOREIGN KEY (`thumbup_user`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE user_event (
  `user_id` char(10) NOT NULL,
  `event_id` int(11) NOT NULL,
  `create_user` varchar(10) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(10) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  KEY `user_id_idx` (`user_id`),
  KEY `event_id_idx` (`event_id`),
  CONSTRAINT `event_id_1` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_id_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE user_group_management (
  `user_id` char(10) NOT NULL,
  `user_group_id` char(10) NOT NULL,
  `create_user` varchar(10) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(10) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  KEY `11_idx` (`user_id`),
  KEY `user_group_id_idx` (`user_group_id`),
  CONSTRAINT `user_group_id` FOREIGN KEY (`user_group_id`) REFERENCES `user_group` (`user_group_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

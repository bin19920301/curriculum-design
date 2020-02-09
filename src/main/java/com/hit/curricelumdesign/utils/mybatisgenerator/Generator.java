package com.hit.curricelumdesign.utils.mybatisgenerator;

import org.mybatis.generator.api.ShellRunner;

public class Generator {
	public static void main(String[] args) {
		//-overwrite 覆盖已有文件
		//args = new String[] { "-configfile", "/Users/dinohsu/IdeaProjects/curricelum-design/src/main/resources/generator.xml" };
		args = new String[] { "-configfile", "F:\\workspace\\curriculum_design\\src\\main\\resources\\generator.xml" };
		ShellRunner.main(args);
		System.out.println("========生成完毕========");
	}
}

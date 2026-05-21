resource "aws_security_group" "crm_sg" {

  name = "crm-security-group"

  ingress {
    from_port   = 8080
    to_port     = 8080
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_instance" "crm_server" {

  ami           = "ami-0011568c11c698d02"
  instance_type = "t3.micro"

  security_groups = [
    aws_security_group.crm_sg.name
  ]

  key_name = "crm-key"

  tags = {
    Name = "CRM-SpringBoot"
  }
}
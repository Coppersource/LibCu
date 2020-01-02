#include <libcu/lasershark.h>

namespace libcu
{

Lasershark::Lasershark(frc::DigitalSource &source)
{
    this->pwmInput = new frc::DutyCycle(source);
}

Lasershark::Lasershark(frc::DigitalSource *source)
{
    this->pwmInput = new frc::DutyCycle(source);
}

Lasershark::Lasershark(std::shared_ptr<frc::DigitalSource> source)
{
    this->pwmInput = new frc::DutyCycle(source);
}

double Lasershark::GetDistanceFeet()
{
    return this->pwmInput->GetOutput() * 4000 / 25.4 / 12;
}

double Lasershark::GetDistanceInches()
{
    return this->pwmInput->GetOutput() * 4000 / 25.4;
}

double Lasershark::GetDisctanceCentimeters()
{
    return this->pwmInput->GetOutput() * 4000 / 10.0;
}
} // namespace libcu
